package problems.movieticketbookingsystem.models;

public interface IPaymentStrategy {
    public void pay(int amount);
}