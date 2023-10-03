public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void takeOff() {
        if(!this.flying && this.altitude == 0) {
            this.flying = true; 
            System.out.printf(getName() + "%s takes off in the sky.%n");
        }
    }

    @Override
    public void glide() {
        if (this.flying && this.altitude != 0) {
            System.out.printf("%s glides into the air.%n");
        }
    }
    
    /**
     * fly upward
     * @param meters altitude increase
     * @return altitude
     */

     @Override
     public int ascend(int meters) {
        if (this.flying) {
            this.altitude = Math.min(this.altitude + meters, 325);
            System.out.printf(getName() + "%s flies upward, altitude: %n" + this.altitude);
        }
        return this.altitude;
     }

     /**
     * fly downward
     * @param meters altitude decrease
     * @return altitude
     */

     @Override
     public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.min(this.altitude - meters, 0);
            System.out.printf(getName() + "%s flies downward, altitude: %n" + this.altitude);
        }
        return this.altitude;
     }

     @Override
     public void land() {
        if (this.flying && this.altitude <= 1) {
            System.out.printf(getName() + "%s lands on the ground. %n");
        } else {
            System.out.printf(getName() +"%s is too high, it can't land. %n");
        }
     }

}
