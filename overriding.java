class vehicle{
    public void attribute(){
        System.out.println("this is a vehicle");
    }
}

class car extends vehicle{
    @Override

    public void attribute(){
        System.out.println("it can either be a lorry, bus or a saloon");
    }
}

class model extends car{

    @Override

    public void attribute(){
        System.out.println("the model is bmw");
    }

}

class main{
public static void main(String[]args){

    vehicle objvehicle = new vehicle();
    car objcar = new car();
    model objmodel = new model();
    objvehicle.attribute();
    objcar.attribute();
    objmodel.attribute();

}
    
}


