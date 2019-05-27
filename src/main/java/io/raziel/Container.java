package io.raziel;

import processing.core.PApplet;
import processing.core.PVector;

public class Container
{

    private PVector position ;
    private PVector color ;
    private float size ;
    private float padding ;

    private Boolean filled ;

    Container( PVector position )
    {

        this.position = position ;
        this.color = new PVector( 255.0f, 255.0f, 255.0f ) ;
        this.size = 200.0f ;
        this.padding = 20.0f ;

        this.filled = false ;
    }

    public void draw( PApplet app )
    {

        app.fill( this.color.x, this.color.y, this.color.z, 0) ;
        app.rect( this.position.x, this.position.y, this.size, this.size ) ;

        if( this.filled ) { /*
            app.pushStyle() ;
                app.noFill() ;
                app.stroke( 255.0f, 0.0f, 0.0f ) ;
                app.strokeWeight( 5.0f ) ;
                app.ellipse(this.position.x+this.size*0.5f, this.position.y+this.size*0.5f, 150.0f, 150.0f);
            app.popStyle() ; */
            app.pushStyle() ;
                app.noFill() ;
                app.stroke( 0.0f, 255.0f, 0.0f ) ;
                app.strokeWeight( 5.0f ) ;
                app.line( this.padding+this.position.x, this.padding+this.position.y, this.position.x+this.size-this.padding, this.position.y+this.size-this.padding ) ;
                app.line( this.padding+this.position.x, this.position.y+this.size-this.padding, this.position.x+this.size-this.padding, this.padding+this.position.y ) ;
            app.popStyle() ;
        }
    }

    public void fillIn()
    {

        if( !this.filled )
            this.filled = true;
    }

    public Boolean collideWithPoint( PVector v1 )
    {

        return ( (v1.x > this.position.x && v1.x < this.position.x+this.size) &&
                 (v1.y > this.position.y && v1.y < this.position.y+this.size) ) ;
    }

}
