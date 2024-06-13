public abstract  class Actor implements ActorBehavior{
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;

    protected final String name;

    public Actor(String name){
        this.name = name;
    }

    public abstract String getName();

}
