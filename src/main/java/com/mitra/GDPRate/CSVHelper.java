package com.mitra.GDPRate;
import com.mitra.GDPRate.Model.Country;
import com.mitra.GDPRate.Model.GDP;
import com.mitra.GDPRate.Repository.CountryRepository;
import com.mitra.GDPRate.Repository.GDPRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Country Name", "Country Code"};


    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<Country> csvToCountries(InputStream is, CountryRepository countryRepository, GDPRepository gdpRepository) {
        Logger logger = LoggerFactory.getLogger(CSVHelper.class);
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Country> countryList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            List<String> headers = csvParser.getHeaderNames();
            List<GDP> gdps = new ArrayList<>();

            for (CSVRecord csvRecord : csvRecords) {
                Country developerTutorial = new Country(
                        csvRecord.get("Country Code"),
                        csvRecord.get("Country Name")
                );

                countryList.add(developerTutorial);
                for (int i = 2; i <headers.size() ; i++) {
                    Double gdprate = 0.0;
                    if(!csvRecord.get(headers.get(i)).isEmpty()){
                        gdprate = Double.parseDouble(csvRecord.get(headers.get(i)));
                    }
                    GDP gdp = new GDP(Integer.parseInt(headers.get(i)), csvRecord.get("Country Code"),gdprate);
                    gdps.add(gdp);
                }
            }
            countryRepository.deleteAll();
            gdpRepository.deleteAll();
            countryRepository.saveAll(countryList);
            gdpRepository.saveAll(gdps);
            return countryList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

//    public static ByteArrayInputStream tutorialsToCSV(List<Country> developerTutorialList) {
//        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
//
//        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
//             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
//            for (Country country : developerTutorialList) {
//                List<String> data = Arrays.asList(
//                        country.getCode(),
//                        country.getName()
//                );
//
//                csvPrinter.printRecord(data);
//            }
//
//            csvPrinter.flush();
//            return new ByteArrayInputStream(out.toByteArray());
//        } catch (IOException e) {
//            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
//        }
//    }

}
