//import java.util.HashMap;
//import java.util.Map;
//
//public enum  GMCommand {
//
//    电器(99){
//        @Override
//        public String doGM(Session session, long uid, String[] params) {
//            return GMHandler.productItem(session, uid, params);
//        }
//    },
//    手机(99){
//        @Override
//        public String doGM(Session session, long uid, String[] params) {
//            return GMHandler.productItem(session, uid, params);
//        }
//    }
//    ;
//
//    private int level;
//
//    GMCommand(int level) {
//        this.level = level;
//    }
//
//    public int getLevel() {
//        return level;
//    }
//
//    public abstract String doGM(Session session, long uid, String[] params);
//
//
//    private static final Map<String, GMCommand> commandMap = new HashMap<>();
//
//    static {
//        for (GMCommand command : GMCommand.values()) {
//            commandMap.put(command.name(), command);
//        }
//    }
//
//    public static GMCommand getCommand(String name) {
//        return commandMap.get(name);
//    }
//}
