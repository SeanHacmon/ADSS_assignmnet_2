public class VipService extends Service{

    public VipService(String serviceName) {
        super(serviceName);
    }

    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }

    @Override
    public String getServiceType() {
        return "VIP Service";
    }
}
