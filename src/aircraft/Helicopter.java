package aircraft;

import weather.Logger;
import weather.WeatherTower;
import weather.Simulation;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower = Simulation.weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);

        this.coordinates.setLatitude(coordinates.getLatitude());
        this.coordinates.setLongitude(coordinates.getLongitude());
        this.coordinates.setHeight(coordinates.getHeight());
        registerTower(weatherTower);
    }

    @Override
    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);

        if(weather.equals("RAIN")){
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("Helicopter#" + this.name + "(" + this.id + ") The rain is getting me a bit wet!");
        } else if (weather.equals("FOG")){
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("Helicopter#" + this.name + "(" + this.id + ") I can't see anything. It's too Foggy!");
        } else if (weather.equals("SUN")) {
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("Helicopter#" + this.name + "(" + this.id + ") It's a beautiful sunny day for a Heli.");
        } else if (weather.equals("SNOW")) {
            this.coordinates.setHeight(this.coordinates.getHeight() - 12);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("Helicopter#" + this.name + "(" + this.id + ") Choppers don't like snow!");
        }
        else{
            return ;
        }

        if(this.coordinates.getHeight() <= 0){
            Logger.log("Helicopter#" + this.name + "(" + this.id + ") Has landed");
            Logger.log("Tower says : Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower");
            weatherTower.unregister(this);
        }


    }

    public void registerTower(WeatherTower weatherTower){
        Logger.log("Tower says : Helicopter#" + this.name + "(" + this.id + ") registered to weather tower");

    }
}
