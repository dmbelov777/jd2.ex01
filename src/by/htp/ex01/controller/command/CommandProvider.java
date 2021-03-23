package by.htp.ex01.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.ex01.controller.command.impl.ChangeLang;
import by.htp.ex01.controller.command.impl.DeleteNews;
import by.htp.ex01.controller.command.impl.EditNews;
import by.htp.ex01.controller.command.impl.GoToContentPage;
import by.htp.ex01.controller.command.impl.GoToIndexPage;
import by.htp.ex01.controller.command.impl.GoToMainPage;
import by.htp.ex01.controller.command.impl.GoToRegistrationPage;
import by.htp.ex01.controller.command.impl.Logination;
import by.htp.ex01.controller.command.impl.Logout;
import by.htp.ex01.controller.command.impl.SaveEditNews;
import by.htp.ex01.controller.command.impl.SaveNewUser;

public class CommandProvider {
	
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
		commands.put(CommandName.SAVENEWUSER, new SaveNewUser());
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.GOTOCONTENTPAGE, new GoToContentPage());
		commands.put(CommandName.EDITNEWS, new EditNews());
		commands.put(CommandName.SAVEEDITNEWS, new SaveEditNews());
		commands.put(CommandName.DELETENEWS, new DeleteNews());
		commands.put(CommandName.CHANGELANG, new ChangeLang());
	}
	
	public Command takeCommand(String name) {
		CommandName commandName;
		
		commandName = CommandName.valueOf(name.toUpperCase());
		
		return commands.get(commandName);
	}

}
