//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args){

//  new Splash();

  Splash frame = new Splash();

  int x = 1;
  for(int i=1; i<500; x+=7, i+=6){
    frame.setLocation(750 - (x+i)/2, 400-(i/2));
    frame.setSize(x+i, i);
    try{
      Thread.sleep(10);
    }catch (Exception e) {}
  }

}
