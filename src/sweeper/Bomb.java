package sweeper;

class Bomb
{
    private Matrix bombMap;
    private int totalBombs;

    Bomb (int totalBombs)
    {
        this.totalBombs = totalBombs;
    }

    void start ()
    {
        bombMap = new Matrix (Box.ZERO);
        for (int j = 0; j < totalBombs; j++)
            placeBomb ();
    }

    Box get (Coord coord)
    {
        return bombMap.get(coord);
    }

    private void placeBomb ()
    {
        Coord coord = Ranges.getRandomCoord();
        bombMap.Set(coord, Box.BOMB);
    }



}



