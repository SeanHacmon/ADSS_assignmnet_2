public class RegularService extends Service {


    public RegularService(String serviceName) {
        super(serviceName);
    }

    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }

    @Override
    public String getServiceType() {
        return "Regular Service";
    }
}
