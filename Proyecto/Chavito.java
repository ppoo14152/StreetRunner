import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Thread;
public class Chavito extends Actor
{
    GreenfootImage[] chavo = new GreenfootImage[7];//El arreglo de tipo GreenfootImage guarda todas las imagenes que pertenecen al movimiento del actor
    private boolean isWalking;
    private int shootTimer;
    private int walkTimer;
    private int walkTimer2;
    private int jumpTimer;
    private int iBandera;
    private int iBandera2;
    private int iCount;
    public Chavito()
    {
        chavo[0] = new GreenfootImage("chavo1.png");//chavitoWalk1
        chavo[1] = new GreenfootImage("chavo2.png");//chavitoWalk2
        chavo[2] = new GreenfootImage("chavo3.png");//chavitoBendOver
        chavo[3] = new GreenfootImage("chavo4.png");//chavitoUpStairs
        chavo[4] = new GreenfootImage("chavo5.png");//chavitoJump
        chavo[5] = new GreenfootImage("chavo6.png");//chavitoDead1
        chavo[6] = new GreenfootImage("chavo7.png");//chavitoDead2
        walkTimer = 0;
        iBandera = 0;
        iBandera2 = 0; 
        iCount = 0;
    }
    //Esta clase se encarga de todo lo que puede hacer el chavo siempre y cuando este tenga aun vida//
    public void act()
    {
        setActions();
    }
    //setActions() se encarga de checar que tecla esta presionada para asi determinar que hacer//
    public void setActions()
    {
        int iCoorY = getY();
        setJump();
        setCrouch();
        setMove();    
    }

    public void setJump()
    {
        if (Greenfoot.isKeyDown("space")){
            iBandera = 1;
        }
        if (iBandera==1 || iBandera2==1){
            if(iBandera==1){
                setImage(chavo[4]);
                setLocation(getX(),getY()-1);
                iCount++;
                if(iCount==65){
                    iBandera=0;
                    iBandera2=1;
                }
            }

            if(iBandera2==1){
                setImage(chavo[4]);
                setLocation(getX(),getY()+1);
                iCount--;
                if(iCount==0){
                    iBandera2=0;
                    setImage(chavo[0]);
                }
            }
        }
    }

    public void setCrouch()
    {
        if (Greenfoot.isKeyDown("down")){
            setImage(chavo[2]);
        }
    }

    public void setMove()
    {
        if(getX()<970){
            if (Greenfoot.isKeyDown("right")){
                move(walkTimer);
                walkTimer ++;
                if(walkTimer == 0){
                    setImage(chavo[0]);
                }
                if(walkTimer == 3){
                    setImage(chavo[1]);
                }
                if(walkTimer == 6){
                    walkTimer = 0;
                    setImage(chavo[0]);
                }
            }
        }
        if(getX()>50){
            if (Greenfoot.isKeyDown("left")){
                move(walkTimer);
                walkTimer --;
                if(walkTimer == 0){
                    setImage(chavo[0]);
                }
                if(walkTimer == -3){
                    setImage(chavo[1]);
                }
                if(walkTimer == -6)
                {
                    walkTimer = 0;
                    setImage(chavo[0]);
                }
            }
        }
    }
}
