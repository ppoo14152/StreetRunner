// Create a new world with 1024x544 cells with a cell size of 1x1 pixels.
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Vecindad extends World
{
    public Chavito chavo;
    public Plataforma1 plataforma;
    private int iNivel;
    public Vecindad()
    {    
        super(1020, 544, 1); 
        chavo = new Chavito();
        plataforma = new Plataforma1();
        iNivel = 1;
        Aniadir();
    }

    public void Aniadir()
    {
        /**
         * Dependiendo del nivel se añadira una platadforma diferente
         * Tambien se añadira al actor principal del juego
         * Y A sus respectivos enemigos
         */
        if(iNivel==1){
            addObject(chavo,50,465);
            addObject(plataforma,511,272);
        }
    }
}
