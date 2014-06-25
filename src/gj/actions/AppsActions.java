package gj.actions;

import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

public class AppsActions extends Actions {
	public static LinkedHashMap<String, GJAction> getActions() {
		return getActions("Apps");
	}

	private static void add(GJAction action) {
		action.setDecription(action.getName()+" 1$");
		add("Apps", action);
	}

	static {
		add(new GJAction("Chat","chat16.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(GJAction.Separator());
		
		add(new GJAction("Timer", "timer.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		add(new GJAction("New Event","new-event.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		add(new GJAction("New Alarm", "new-alarm.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		add(new GJAction("New Mail","new-mail.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(new GJAction("New Contact","new-contact.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("New Audio Record", "sound-input.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("New Video Record", "video-recorder.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("New Screen Record", "video-recorder.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("Screen Capture") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(GJAction.Separator());
		
		add(new GJAction("Events", "events.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		add(new GJAction("Alarms", "alarm.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});


		add(new GJAction("Mail Box") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		add(new GJAction("Address Book", "charm-note-book.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("Cook Book","cook-book.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("Image Manager") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("Audio Manager") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("Video Manager") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("Dictionary","define.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("Downloader") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(new GJAction("Activity Report") {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
}
