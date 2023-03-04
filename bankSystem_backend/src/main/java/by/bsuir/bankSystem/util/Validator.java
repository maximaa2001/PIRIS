package by.bsuir.bankSystem.util;

import by.bsuir.bankSystem.dao.ClientDao;
import by.bsuir.bankSystem.entity.domain.Client;
import by.bsuir.bankSystem.exception.BadRequestException;
import by.bsuir.bankSystem.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Service
public class Validator {
    private final ClientDao clientDao;
    private static final DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd");

    @Autowired
    public Validator(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void checkExistUserWith(String surname, String name, String lastName) {
        Optional<Client> optionalClient = clientDao.findBySurnameAndNameAndLastname(surname, name, lastName);
        if (optionalClient.isPresent()) {
            throw new ConflictException("client with such surname, name and lastname already exists");
        }
    }

    public void checkExistUserWith(String partPassport, String numberPassport) {
        Optional<Client> optionalClient = clientDao.findByPassport(partPassport, numberPassport);
        if (optionalClient.isPresent()) {
            throw new ConflictException("client with such passport already exists");
        }
    }

    public void checkExistUserWith(String identifierNumber) {
        Optional<Client> optionalClient = clientDao.findByIdentifierNumber(identifierNumber);
        if (optionalClient.isPresent()) {
            throw new ConflictException("client with such identifier number already exists");
        }
    }

    public LocalDate validateDate(String date) {
        try {
            dateFormatter.parse(date, Locale.getDefault()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            throw new BadRequestException("not valid date");
        }
    }

    public static String dateToString(Date date) {
        return dateFormatter.print(date, Locale.getDefault());
    }
}
