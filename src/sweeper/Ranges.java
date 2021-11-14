package sweeper;

public class Ranges     // класс для хранения поля и некоторых полезных функций
{

    private static Coord size; //координата размера нашего экрана

    public static void setSize(Coord _size)
    {
        size = _size;
    }

    public static Coord getSize()
    {
        return size;
    }

}
