package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Ticket;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    int countByUserAccount(User user);

    Integer countAllByUserAccountId(Long userId);
    //Write a derived query to list all tickets by specific email
    List<Ticket> findTicketByUserAccount_Email(String email);


    //Write a derived query to count how many tickets are sold for a specific movie
    int countAllByMovieCinemaMovieName(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime startDateTime,LocalDateTime endDateTime);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount=?1")
    List<Ticket> fetchAllTicketsFromUser(Long userId);

    @Query("SELECT t FROM Ticket t WHERE t.userAccount=?1")
    List<Ticket> fetchAllTicketsByUserAccount(@Param("userId") Long userId);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> fetchAllTicketsBetweenDates(LocalDateTime startDate, LocalDateTime endDate);


    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> fetchAllTicketsBetweenRangeOfDateTimes(@Param("startDateTime") LocalDateTime startDateTime,@Param("endDateTime") LocalDateTime endDateTime);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT * FROM ticket WHERE user_account_id = ?1",nativeQuery = true)
    int countTicketUserBought(Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT * FROM ticket WHERE user_account_id = ?1 AND t.dateTime BETWEEN ?2 AND ?3",nativeQuery = true)
    int countTicketUserBoughtInRangeOfTime(Long userId, LocalDateTime startDate, LocalDateTime endDate);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT * FROM ticket t " +
            "JOIN movie_cinema mc " +
            "ON mc.id = t.movie_cinema_id " +
            "JOIN movie m " +
            "ON m.id = mc.movie_id " +
            "WHERE m.name = (SELECT DISTINCT m.name FROM movie)",nativeQuery = true)
    List<Ticket> fetchAllDistinctByMovieName();

    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id WHERE ua.email = ?1",nativeQuery = true)
    List<Ticket> fetchByUserEmail(@Param("email") String email);

    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket",nativeQuery = true)
    List<Ticket> fetchAllTickets();


    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(value = "SELECT * FROM ticket t " +
            "JOIN user_account ua ON t.user_account_id=ua.id " +
            "JOIN account_details ad ON ua.account_details_id=ad.id " +
            "JOIN movie_cinema mc ON t.movie_cinema_id=mc.id " +
            "JOIN movie m ON mc.cinema_id=m.id " +
            "WHERE ua.username ILIKE concat ('%',?1,'%') " +
            "OR ad.name ILIKE concat ('%',?1,'%') " +
            "OR m.name ILIKE concat ('%',?1,'%')",nativeQuery = true)
    List<Ticket> fetchAllTicketsContains(@Param("pattern")String pattern);


    //Hilal - problem
    @Query(value=" select * from ticket t join user_account u on t.user_acoount_id=u.id " +
            "join account_details a on u.accoun_details_id=a.id join movie_cinema mc on t.movie_cinema_id=mc.id join movie m on mc.movie_id=m.id where u.username ILIKE concat('%',?1,'%')" +
            "OR a.name account_details OR m.name account_details ILIKE concat('%',?1,'%') ",nativeQuery = true)
    List<Ticket> allTicketsContainsValue(@Param("pattern") String pattern);

    // Jamal
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id " +
            "JOIN account_details ad ON ad.id = ua.account_details_id " +
            "JOIN movie_cinema mc ON mc.id = t.movie_cinema_id " +
            "JOIN movie m ON mc.movie_id = m.id " +
            "WHERE ua.username ILIKE concat('%',?1,'%') " +
            "OR ad.name ILIKE concat('%',?1,'%') " +
            "OR m.name ILIKE concat('%',?1,'%') ",nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(@Param("searchCriteria") String searchCriteria);

}
