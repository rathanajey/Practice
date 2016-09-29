import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Television Assignment

/**
 * Goal: Implement the constructor and methods below.
 *
 * Guidelines:
 * 1. Use any programming language you like. If you switch away from Java, please rewrite the code below in your
 *    desired language. Please use actual code (no pseudocode).
 * 2. Feel free to add any additional private member methods/variables/classes.
 * 3. Please capture any assumptions that you make about the program.
 *
 * Question:
 * Is your solution optimal? If so, why?
 */

/**
 * Class to Model a Television.
 */
public class Television {
	
	private HashMap<String, String> channelNumberToNameMap;
	private Channel currentChannel;
	
	public HashMap<String, String> getChannelNumberToNameMap() {
		return channelNumberToNameMap;
	}

	public void setChannelNumberToNameMap(HashMap<String, String> channelNumberToNameMap) {
		this.channelNumberToNameMap = channelNumberToNameMap;
	}

	public Channel getCurrentChannel() {
		return currentChannel;
	}

	public void setCurrentChannel(Channel currentChannel) {
		this.currentChannel = currentChannel;
	}

	/**
	* Constructor
	*
	* @param channelNumberToNameMap A map of every channel number and its corresponding channel name
	*
	* NOTE: It is safe to assume that the channelNumberToNameMap's keys will all be numeric and positive
	*       and the values will be non-null/whitespace. In addition, channelNumberToNameMap will not be empty.
	*       Do not make any other assumptions about channelNumberToNameMap or the data it contains.
	*/
	public Television(Map<String, String> channelNumberToNameMap) {
		this.channelNumberToNameMap = (HashMap<String, String>) channelNumberToNameMap;
		this.currentChannel = createOrderedChannelList(this.channelNumberToNameMap);
	}
	
	private Channel createOrderedChannelList(HashMap<String, String> channelNumberToNameMap){
		Channel channel = null;
		Channel headChannel = null;
		
		for(Map.Entry<String, String> entry:channelNumberToNameMap.entrySet()){
			int channelNum = Integer.parseInt(entry.getKey());
			String channelName = entry.getValue();
			channel = new Channel(channelNum, channelName);
			headChannel = insertChannelInOrder(headChannel, channel);
		}
		
		return headChannel;
	}
	
	private Channel insertChannelInOrder(Channel headChannel, Channel channel){
		if(headChannel == null) return channel;
		System.out.println("The head INSIDE is " + headChannel.getChannelNum());
		System.out.println("The channel INSIDE is " + channel.getChannelNum());
		
		Channel currentChannel = headChannel;
		Channel tailChannel = null;
		
		boolean  traversedFullList = false;
		
		while(!traversedFullList){
			if(channel.getChannelNum() <= currentChannel.getChannelNum()){
				channel.setNextChannel(currentChannel);
				channel.setPreviousChannel(currentChannel.getPreviousChannel());
				if(currentChannel.getPreviousChannel() != null){
					currentChannel.getPreviousChannel().setNextChannel(channel);
				}
				currentChannel.setPreviousChannel(channel);
				if(headChannel == currentChannel){
					return channel;
				}
				else{
					return headChannel;
				}
			}
			tailChannel = currentChannel;
			currentChannel = currentChannel.getNextChannel();
			if(currentChannel == headChannel){
				traversedFullList = true;
			}
		}
		
		channel.setPreviousChannel(tailChannel);
		tailChannel.setNextChannel(channel);
		channel.setNextChannel(headChannel);
		headChannel.setPreviousChannel(channel);
		
		System.out.println("Before exit INSIDE is " + channel.getChannelNum());
		return headChannel;
	}
	
	public void printList(){
		System.out.println("The head is " + this.currentChannel.getChannelNum());
		Channel current = this.currentChannel;
		while(current.getNextChannel() != this.currentChannel){
			System.out.println(current.getChannelNum());
			current = current.getNextChannel();
		}
		
		System.out.println(current.getChannelNum());
		
		System.out.println("The head is " + this.currentChannel.getChannelNum());
	}
	
	/**
	* Changes the Television to the desired channel.
	*
	* @param channelNumber The desired channel number
	* @return The name of the desired channel
	*/
	public String goToChannel(String channelNumber) {
		String channelName = "";
		
		if(channelNumber.isEmpty() || channelNumber.equals("")){
			channelName = "Channel number cannot be empty";
		}
		
		channelName = this.channelNumberToNameMap.get(channelNumber);		
		if(channelName != null){
			updateCurrentChannel(channelNumber);
			return channelName;
		}
		
		channelName = "Channel number does not exist";
		
		return channelName;
	}
	
	private void updateCurrentChannel(String channelNumber){
		int channelNum = Integer.parseInt(channelNumber);
		Channel current = this.currentChannel;
		
		if(current.getChannelNum() == channelNum){
			return;
		}
		
		Channel previous = this.currentChannel.getPreviousChannel();
		Channel next = this.currentChannel.getNextChannel();
		
		while(previous.getChannelNum() != channelNum && next.getChannelNum() != channelNum){
			previous = previous.getPreviousChannel();
			next = next.getNextChannel();
		}
		
		this.currentChannel = (previous.getChannelNum() == channelNum) ? previous: next;
	}
	
	/**
	* Changes the Television channel once in an ascending direction.
	*
	* @return The name of the next channel
	*/
	public String channelUp() {
	// TODO
		return null;
	}
	/**
	* Changes the Television channel once in a descending direction.
	*
	* @return The name of the previous channel
	*/
	public String channelDown() {
	// TODO
		return null;
	}
}

class Channel{
	private Channel previousChannel;
	private Channel nextChannel;
	private int channelNum;
	private String channelName;
	
	Channel(int channelNum, String channelName){
		this.channelNum = channelNum;
		this.channelName = channelName;
		this.previousChannel = null;
		this.nextChannel = null;
	}
	
	public Channel getPreviousChannel() {
		return previousChannel;
	}

	public void setPreviousChannel(Channel previousChannel) {
		this.previousChannel = previousChannel;
	}

	public Channel getNextChannel() {
		return nextChannel;
	}

	public void setNextChannel(Channel nextChannel) {
		this.nextChannel = nextChannel;
	}

	public int getChannelNum() {
		return channelNum;
	}

	public void setChannelNum(int channelNum) {
		this.channelNum = channelNum;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
}







/* EDGE CASES:
Funcional:
1) Requesting a channel number that isnt available.
2) calling channelUp when max channel has already been reached.
3) Calling channelDown when min channel has already been reached.
4) If TV is switched on and off, should it fetch the last viewed channel?

Edge cases:
1) The map keys in the map are not coniguous.
2) The current channel is not known.
3) 



*/
