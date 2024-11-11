public interface FlipFitAdminService{
    public List<User> getUserList();
    public void addGym(String regionId,int pinCode);
    public void updateAdminPassword(String userName,String newPassword);
}