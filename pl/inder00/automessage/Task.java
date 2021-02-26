package pl.inder00.automessage;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Task extends BukkitRunnable {

	int currentMsg = 0;
	int count = 0;
	
	public Task(){
		
		this.count = AutoMessage.messages.size();
		
	}
	
	@Override
	public void run() {
		
		if(currentMsg == count){
			currentMsg = 0;
		}

		String msg = AutoMessage.messages.get(currentMsg).toString().replace("{ONLINE}", ""+Bukkit.getOnlinePlayers().size());

		String[] args = msg.split("@@@");

		for(String s : args){
			Bukkit.broadcastMessage(s);
		}
		currentMsg++;
		
	}

}
