package ch05;



import java.time.LocalDateTime;
import java.time.LocalTime;

public class Screening {
    private Movie movie;
    private int seq;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int seq, LocalDateTime whenScreened) {
        this.movie = movie;
        this.seq = seq;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer,this, calculateFee(audienceCount), audienceCount);
    }
    private Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).Times(audienceCount);
    }
    public Money getMovieFee() {
        return movie.getFee();
    }

    public boolean isSeq(int seq) {
        return this.seq == seq;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }
}
