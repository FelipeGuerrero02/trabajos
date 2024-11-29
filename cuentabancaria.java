class cuentabancaria {
    public static void main(String[] args) {
        double AmountInitial = 1000.0;
        double AmountWeek = 200.0;
        int NumberWeek = 4;
        double Total = AmountWeek * NumberWeek;
        double MoneyRemaining = AmountInitial - Total;
        System.out.println("Dinero restante en la cuenta al final del mes: " + MoneyRemaining);
    }
}
