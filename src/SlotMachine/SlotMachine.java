package SlotMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс игрового автомата
 */
public class SlotMachine extends Thread
{
    // Список игровых барабанов
    private List<Wheel> wheels = new ArrayList<>();

    // Признак выигрыша
    boolean isWin;

    /**
     * Конструктор игрового автомата
     */
    public SlotMachine()
    {
        isWin = false;
    }

    @Override
    public void run()
    {
        setWheels(3); // создание игровых барабанов

        for (Wheel w : wheels) w.start(); // запуск игровых барабанов

        // Ожидание завершения работы всех игровых барабанов
        for (Wheel w : wheels)
        {
            try
            {
                w.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод получения результат игры
     * @return результат игры, истина если на всех барабанах одинаковое значение
     */
    public boolean isWin()
    {
        isWin = true;
        String val = "";
        for (Wheel w : wheels)
        {
            if(w.getSlotValue().isEmpty())
            {
                isWin = false;
                break;
            }
            if(val.isEmpty()) val = w.getSlotValue();
            else if (!val.equals(w.getSlotValue()))
            {
                isWin = false;
                break;
            }
        }
        return isWin;
    }

    // Создание игровых барабанов согласно заданному количеству
    private void setWheels(int num)
    {
        wheels.clear();
        for(int i = 0; i < num; i++)
            wheels.add(new Wheel(String.valueOf(i + 1)));
    }
}
