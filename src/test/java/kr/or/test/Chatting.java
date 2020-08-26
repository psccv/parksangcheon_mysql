package kr.or.test;

public class Chatting {
	
	public static void main(String[] args) {
		Chatting chat = new Chatting();
		chat.startChat("까꿍");
	}
	
	void startChat(String chatId) {
		String nickName = chatId;
		//nickName = chatId;
		
		Chat chat = new Chat() {
			@Override
			public void start() {
				while(true) {
					String inputData = "채팅방 입장을 환영합니다.";
					String message = "["+ nickName +"] 님 "+ inputData;
					sendMessage(message);
					break;
				}
			}
		};
		chat.start();
	}
	
	class Chat {
		void start() {
			
		}
		void sendMessage(String message) {
			System.out.println(message);
		}
	}
}
