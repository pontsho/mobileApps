package org.globalcauseway.gcmobile.client.activities;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class UIEntrySelectedEvent extends Event<UIEntrySelectedEvent.Handler> {

	public enum UIEntry {
		EMAIL_LOGIN, HOMEPAGE, ELEMENTS, POPUPS, SEARCH ,PASSWORD_RESET, SIGNUP 
	}

	public interface Handler {
		void onAnimationSelected(UIEntrySelectedEvent event);
	}

	private static final Type<UIEntrySelectedEvent.Handler> TYPE = new Type<UIEntrySelectedEvent.Handler>();
	private final UIEntry entry;

	public static void fire(EventBus eventBus, UIEntry entry) {
		eventBus.fireEvent(new UIEntrySelectedEvent(entry));
	}

	public static HandlerRegistration register(EventBus eventBus, Handler handler) {
		return eventBus.addHandler(TYPE, handler);
	}

	@Override
	public com.google.web.bindery.event.shared.Event.Type<Handler> getAssociatedType() {
		return TYPE;
	}

	protected UIEntrySelectedEvent(UIEntry entry) {
		this.entry = entry;

	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onAnimationSelected(this);

	}

	public static Type<UIEntrySelectedEvent.Handler> getType() {
		return TYPE;
	}

	public UIEntry getEntry() {
		return entry;
	}
}
