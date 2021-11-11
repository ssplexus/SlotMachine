package SlotMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс игрового барабана
 */
public class Wheel extends Thread
{
    /**
     * Статический список возможных значений на барабане
     */
    public static final List<String> slotVals = new ArrayList<>(List.of("Cherry", "Banana", "Monkey", "Seven", "Ace", "Diamond"));

    // Текущее значение
    private String slotValue;

    /**
     * Конструктор барабана
     * @param name - наименование барабана (номер)
     */
    public Wheel(String name)
    {
        super(name);
        slotValue = "";
    }

    @Override
    public void run()
    {
        int finVal = 0;
        // Реализация механизма барабана
        for(int i = 0; i < new Random().nextInt(300); i++) // цикл со случайным количеством итераций
        {
            if(finVal++ >= slotVals.size()) finVal = 0; // определение номера конечного значения барабана
            try
            {
                sleep(100);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        slotValue = slotVals.get(finVal == 0 ? 0 : --finVal); // получение результирующего значения барабана
        System.out.println(this.getName() + " wheel stopped - [" + slotValue + "]");
    }

    /**
     * Метод получения результата работы барабана
     * @return строковое значение барабана
     */
    public String getSlotValue()
    {
        return slotValue;
    }
}
