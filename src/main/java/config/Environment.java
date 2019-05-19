package config;

public abstract class Environment {

    private OS os;

    public OS getOS() {
        return this.os;
    }

    protected void setOS(OS os) {
        this.os = os;
    }
}
