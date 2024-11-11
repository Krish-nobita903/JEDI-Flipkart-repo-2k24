@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminController{
    private FlipFitAdminService adminService;

    public AdminController(FlipFitAdminServiceOperation adminService){
        System.out.println("/n/n/n In Admin cLass Constructor /n/n/n");
        this.adminService = adminService;
    }

    @GET
    @Path("/viewUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserList(){
        List<User> users = adminService.getUserList();
        return users;
    }


}