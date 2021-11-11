import SlotMachine.SlotMachine;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        SlotMachine slotMachine = new SlotMachine(); // создание слот-машины
        slotMachine.start(); // запуск игрового автомата
        slotMachine.join(); // ожидаем завершения работы автомата
        if(slotMachine.isWin()) // определение результата игры
            System.out.println("YOU WIN!");
        else
            System.out.println("YOU LOSE!");
    }
}
