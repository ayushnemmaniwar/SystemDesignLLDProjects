////UserService and OrderService
//class UserService {
//
//     static UserService userService=null;
//
//    static UserService createInstance() {
//        if(userService==null) {
//            userService = new UserService();
//        }
//        return userService;
//    }
//}
//
//class OrderService {
//    //@autowired
//    final UserService userService;
//    //@Autowired
//    OrderService(UserService userService) {
//        this.userService = userService;
//    }
//
//    //@Transaction
//    void saveOrder() {
//        //update balance and update delivery
//        updateBalance();//write uncommit
//        updateDelivery();
//        //networkcall
//        try {
//
//        } catch () {
//            //rollback all uncommited changes
//
//        }
//    }
//
//    void updateBalance() {
//        //Database
//    }
//
//    void updateDelivery() {
//
//    }
//
//}
//
//
//public class main {
//    public static void main(String []args) {
//        UserService userService = UserService.createInstance();
//        OrderService orderService = new OrderService(userService);
//
//
//    }
//}
//
////Payment (paymentId, initiatedBy(User), AccountDetails,BankDetails, paymentStatus, Amount, Refund(true/false)) (All items)
//// or
////Payment (paymentId,initiatedBy(User), AccountDetails,BankDetails, paymentStatus) (Individual item)
////ItemPayment(itemPaymentId,itemId,paymentId,price,refund(true/false)) foreign key
////or
//
////Amazon->Payment->GooglePay
