package no2;

public class VoterApp {
	private static VoterApp instance = null; 
    private VoterApp() {}

    public static VoterApp getInstance(){
        if ( instance == null ){
            instance = new VoterApp();
        }
        return(instance); 
    }
    public String getPollOfTheDay(){
        String poll = 
        "<H3>What is the best thing about Utah?</H3>" +
        "<INPUT TYPE='RADIO' NAME='vote' VALUE='1'>The Mormon Tabernacle Choir<BR>" +
        "<INPUT TYPE='RADIO' NAME='vote' VALUE='2'>The Utah Jazz<BR>" +
        "<INPUT TYPE='RADIO' NAME='vote' VALUE='3'>Winter Olympics<BR>" +
        "<INPUT TYPE='RADIO' NAME='vote' VALUE='4'>Donnie Osmond<BR>";
        
        return(poll); 
    }
    public void addToPollResults(String foo){
    }
    public byte[] generateImageBytes(){
        byte[] b = new byte[1];
        b[0] = 0; 
        return b; 
    }
}

