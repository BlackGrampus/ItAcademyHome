package by.javacourse.se.project.services;

public class CarServices {

    private final AddOptionsCarService addOptionsCarService;
    private final RemoveOptionsCarService removeOptionsCarService;
    private final ChangeWhellRCarService changeWhellRCarService;
    private final ChangeColorCarService changeColorCarService;

    public CarServices() {
        this.addOptionsCarService = new AddOptionsCarService();
        this.removeOptionsCarService = new RemoveOptionsCarService();
        this.changeWhellRCarService = new ChangeWhellRCarService();
        this.changeColorCarService = new ChangeColorCarService();
    }

    public AddOptionsCarService getAddOptionsCarService() {
        return addOptionsCarService;
    }

    public RemoveOptionsCarService getRemoveOptionsCarService() {
        return removeOptionsCarService;
    }

    public ChangeWhellRCarService getChangeWhellRCarService() {
        return changeWhellRCarService;
    }

    public ChangeColorCarService getChangeColorCarService() {
        return changeColorCarService;
    }
}
