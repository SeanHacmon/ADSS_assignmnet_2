public class CommunityService extends Service{

    public CommunityService(String serviceName) {
        super(serviceName);
    }

    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }

    @Override
    public String getServiceType() {
        return "Community Service";
    }
}