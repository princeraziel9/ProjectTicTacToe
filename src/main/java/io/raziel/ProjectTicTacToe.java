package io.raziel;

import processing.core.* ;

public class ProjectTicTacToe extends PApplet {

    private Container[] containers ;
    final private int CELL_COUNT = 3 ;

    @Override
    public void settings()
    {

        size( 600, 600 ) ;

        this.containers = new Container[ CELL_COUNT ] ;
        this.containers[0] = new Container( new PVector( 0.0f, 0.0f ) ) ;
        this.containers[1] = new Container( new PVector( 200.0f, 0.0f ) ) ;
        this.containers[2] = new Container( new PVector( 400.0f, 0.0f ) ) ;
    }

    @Override
    public void draw()
    {

        background(0) ;

        drawBoard() ;

        for( int n = 0 ; n < CELL_COUNT ; n++ )
            this.containers[n].draw( this ) ;
    }

    public void mouseClicked()
    {

        for( int n = 0 ; n < CELL_COUNT ; n++ )
            if( this.containers[n].collideWithPoint( new PVector( mouseX, mouseY ) )) {
                System.out.println("You clicked container #" + (n + 1));
                this.containers[n].fillIn() ;
            }
    }

    private void drawBoard()
    {

        pushStyle() ;

        stroke( 0, 0, 255.0f ) ;
        strokeWeight( 4.0f ) ;

        // horizontal lines
        line( 0.0f, 200.0f, width, 200.0f ) ;
        line( 0.0f, 400.0f, width, 400.0f ) ;

        // vertical lines
        line( 200.0f, 0.0f, 200.0f, height ) ;
        line( 400.0f, 0.0f, 400.0f, height ) ;

        popStyle() ;
    }

    public static void main( String[] args )
    {

        PApplet.main( ProjectTicTacToe.class.getName() ) ;
    }
}
