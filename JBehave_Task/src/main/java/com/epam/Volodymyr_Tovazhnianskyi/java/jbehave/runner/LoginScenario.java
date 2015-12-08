package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;

import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.contextdriver.ContextDriver;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.steps.MailRuBeforeAndAfterSteps;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.steps.MailRuCheckMessageStep;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.steps.MailRuLoginCheck;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.steps.MailRuSendMessage;

public class LoginScenario extends JUnitStories {

	ContextDriver context = new ContextDriver();

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		ArrayList<Steps> stepFileList = new ArrayList<Steps>();
		stepFileList.add(new MailRuBeforeAndAfterSteps(context));
		stepFileList.add(new MailRuLoginCheck(context));
		stepFileList.add(new MailRuCheckMessageStep(context));
		stepFileList.add(new MailRuSendMessage(context));
		return new InstanceStepsFactory(configuration(), stepFileList);
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
				Arrays.asList("**/*.story"), Arrays.asList(""));

	}
}