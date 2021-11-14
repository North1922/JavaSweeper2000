package sweeper;

class Bomb
{
    private Matrix bombMap;
    private int totalBombs;

    Bomb (int totalBombs)
    {
        this.totalBombs = totalBombs;
    }

    void Start ()
    {
        bombMap = new Matrix (Box.ZERO);
        placeBomb ();
    }

    Box get (Coord coord)
    {
        return bombMap.get(coord);
    }

    private void placeBomb ()
    {
        bombMap.Set(new Coord(4, 4), Box.BOMB);
    }



}



