import javax.swing.*;
import java.awt.*;


import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;


public class JavaSweeper extends JFrame {

    private Game game;
    private JPanel panel;
    private final int COLS = 9;//создаём константу которая указывает колличетсво столбцов
    private final int ROWS = 9;//создаём константу которая указывает колличество строчек
    private final int IMAGE_SIZE = 50;//создаём константу которая оозначает размер одной картинки 50х50


    public static void main(String[] args)
    {
        new JavaSweeper();//создаём экземпляр программы
    }

    private JavaSweeper()
    {
        game = new Game(COLS, ROWS);
        game.start();
        setImages();
        initPanel();
        initFrame();//вызывает инициальзацию фрейма
    }

    private void initPanel()
    {
        panel = new JPanel()
        {//при инициализации панели указываем специальную функцию которая называется PaintComponent(). Именно эта функция вызывается каждый раз когда надо нарисовать форму
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g); //вызываем метод который позволяет выводить нашу картинку. Указывает имя картинки , далее координату и затем указание на ресурс на текущий экземпляр
                     for (Coord coord : Ranges.getAllCoords()) // перебираем элементы из enum Box
                     {
                         g.drawImage((Image) game.getBox(coord).image, coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this); //что бы отобразить картинку берём её из объекта box
                     }
            }

        };

         panel.setPreferredSize(new Dimension(Ranges.getSize().x * IMAGE_SIZE , Ranges.getSize().y * IMAGE_SIZE));//задаём размеры окна.
        /*
        ширина = кол-во столбцов * размер картинки
        высота = кол-во строк * размер картинки
         */
        add (panel);
    }

    private void initFrame()
    {
        pack();// метод pack() устанавливает такой минимальный размер контейнера , который достаточен для отображения всех компонентов
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
    }

    private void setImages ()
    {
        for (Box box : Box.values())//  реализовываем цикл, который перебирает все картинки
            box.image = getImage(box.name().toLowerCase());//  Для каждого экземпляра box устанавливаем картинку , это будет результат функции getImage в которую мы передаём имя нашего элемента. т.е имена элементов каждого box`а совпадают с картинками
    }

    private Image getImage (String name)//функция которая занимается получением картинок по имени файла
    {
        String filename = "img/" + name + ".png"; // имя файла
        ImageIcon icon = new ImageIcon(getClass().getResource(filename)); // загрузка ресурса с именем файла filename
        return icon.getImage(); // возвращаем картинку ресурса

    }

}
