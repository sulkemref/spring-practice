package com.cydeo;

import com.cydeo.enums.Role;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestDB implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public TestDB(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository, MovieRepository movieRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(accountRepository.findByCountryOrState("","New York"));
        System.out.println(accountRepository.findByAgeLessThanEqual(35));
        System.out.println(accountRepository.findByRole(Role.USER));
        System.out.println(accountRepository.findByAgeBetween(10,36));
        System.out.println(accountRepository.findByAddressStartingWith("262"));
        System.out.println(accountRepository.findAllByOrderByAge());
        System.out.println(accountRepository.retrieveAllAccounts());
        System.out.println(accountRepository.retrieveAllAdminAccounts());
        System.out.println(accountRepository.retrieveAllAccountsSortedByAge());
        System.out.println(accountRepository.retrieveAccountsByAgeLowerThan(36));
        System.out.println(accountRepository.retrieveAccountsByNameAndAddressAndCountryAndStateAndCity("Josie D Story","262  Lochmere Lane","United States","LOUISVILLE"));
        System.out.println(accountRepository.retrieveAccountsWhereAgeGraterThan(40));
        System.out.println(cinemaRepository.getByName("Hall 4 - EMPIRE"));
        System.out.println(cinemaRepository.findFirst3BySponsoredNameContainingOrderBySponsoredName("o"));
        System.out.println(cinemaRepository.findTop3BySponsoredNameContainsOrderByName("HBO"));
        System.out.println(cinemaRepository.getAllCinemaByLocation_Country("United States"));
        System.out.println(cinemaRepository.findAllByLocationCountry("United States"));
        System.out.println(cinemaRepository.findByNameOrSponsoredName("Hall 2 - EMPIRE","Channel 4"));
        System.out.println(cinemaRepository.getNameOfCinemaById(1L));
        System.out.println(cinemaRepository.findAllCinemasByLocationCountry("UK"));
        System.out.println(cinemaRepository.findAllCinemasByNameOrSponsoredNameByPattern("HBO"));
        System.out.println(cinemaRepository.retrieveAllSortByName());
        System.out.println(cinemaRepository.retrieveAllDistinctBySponsorName("Walt Disney"));
        System.out.println(genreRepository.retrieveAllGenres());
        System.out.println(genreRepository.retrieveGenresByNameContains("r"));
        System.out.println(movieCinemaRepository.findById(1L));
        System.out.println(movieCinemaRepository.findAllByDateTimeAfter(LocalDateTime.of(2019,1,1,1,1)));
        System.out.println(movieCinemaRepository.findMovieCinemaByMovieName("Tenet"));
        System.out.println(movieCinemaRepository.retrieveByHigherDate(LocalDateTime.of(2019,1,1,1,1)));
        System.out.println(movieCinemaRepository.countAllByCinemaId(7L));
        System.out.println(movieCinemaRepository.countAllByMovieId(1L));
        System.out.println(movieCinemaRepository.findAllByCinemaLocationName("AMC Empire 25"));
        System.out.println(ticketRepository.findTicketByUserAccount_Email("bernard@email.com"));
        System.out.println(ticketRepository.fetchAllDistinctByMovieName());
        System.out.println(ticketRepository.fetchAllTicketsContains("a"));
        System.out.println(ticketRepository.countAllByMovieCinemaMovieName("Tenet"));
        System.out.println(ticketRepository.fetchByUserEmail("josie_story@email.com"));
        System.out.println(ticketRepository.fetchAllTickets());
        System.out.println(userRepository.findByEmail("josie_story@email.com"));
        System.out.println(userRepository.findAllByAccountDetailsNameContains("Parsons"));
        System.out.println(userRepository.findByAccountDetailsNameContainingIgnoreCase("aRSons"));
        System.out.println(userRepository.findByAccountDetailsAgeGreaterThan(40));
        System.out.println(userRepository.fetchUserByEmail("josie_story@email.com"));
        System.out.println(userRepository.fetchUserByUsername("faith"));
        System.out.println(userRepository.fetchAll());
        System.out.println(userRepository.fetchUsersNameContains("a"));
        System.out.println(userRepository.fetchAllUsers());
        System.out.println(userRepository.fetchUsersAgeRange(30,31));
        System.out.println(userRepository.retrieveUserByEmail("josie_story@email.com"));


    }
}
