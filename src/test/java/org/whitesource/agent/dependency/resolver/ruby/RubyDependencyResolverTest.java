package org.whitesource.agent.dependency.resolver.ruby;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.whitesource.agent.dependency.resolver.ResolutionResult;
import org.whitesource.agent.dependency.resolver.npm.TestHelper;

import java.nio.file.Paths;

public class RubyDependencyResolverTest {

    RubyDependencyResolver rubyDependencyResolver;

    @Before
    public void setUp() throws Exception {
        rubyDependencyResolver = new RubyDependencyResolver(true, false, true);
    }

    @Test
    public void resolveDependencies() {
        String folderPath = Paths.get(".").toAbsolutePath().normalize().toString() + TestHelper.getOsRelativePath("\\src\\test\\resources\\resolver\\ruby\\");
        folderPath = "C:\\Users\\ErezHuberman\\Documents\\ruby\\discourse-master";
        ResolutionResult resolutionResult = rubyDependencyResolver.resolveDependencies(folderPath, folderPath, null);
        Assert.assertTrue(resolutionResult.getResolvedProjects().keySet().iterator().next().getDependencies().size() == 71);
    }
}