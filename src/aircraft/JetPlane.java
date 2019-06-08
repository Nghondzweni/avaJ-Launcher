package aircraft;

import weather.Logger;
import weather.Simulation;
import weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower = Simulation.weatherTower;

    JetPlane(String name, Coordinates coordinates){
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
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("JetPlane#" + this.name + "(" + this.id + ") Damn you rain");
        } else if (weather.equals("FOG")){
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("JetPlane#" + this.name + "(" + this.id + ") Too much fog!!");
        } else if (weather.equals("SUN")) {
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("JetPlane#" + this.name + "(" + this.id + ") The sun is out");
        } else if (weather.equals("SNOW")) {
            this.coordinates.setHeight(this.coordinates.getHeight() - 7);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("JetPlane#" + this.name + "(" + this.id + ") JetPlanes shrink in cold snowy weather.");
        }
        else{
            return ;
        }

        if(this.coordinates.getHeight() <= 0){
            Logger.log("JetPlane#" + this.name + "(" + this.id + ") Has landed");
            Logger.log("Tower says : JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        Logger.log("Tower says : JetPlane#" + this.name + "(" + this.id + ") registered to weather tower");
    }
}
