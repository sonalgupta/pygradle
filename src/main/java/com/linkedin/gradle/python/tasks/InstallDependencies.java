package com.linkedin.gradle.python.tasks;

import com.linkedin.gradle.python.internal.toolchain.PythonExecutable;
import org.gradle.api.Action;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.internal.ExecAction;
import org.gradle.util.GFileUtils;

import java.io.File;


public class InstallDependencies extends BasePythonTask {

  private Configuration virtualEnvFiles;

  @TaskAction
  public void doWork() {
    final PythonExecutable pythonExecutable = getPythonToolChain().getLocalPythonExecutable(venvDir);
    final String pipCommand = new File(venvDir, "bin/pip").getAbsolutePath();
    StringBuilder stringBuilder = new StringBuilder();

    for (final File dependency : getVirtualEnvFiles()) {
      stringBuilder.append(dependency.getAbsolutePath()).append("\n");
      pythonExecutable.execute(new Action<ExecAction>() {
        @Override
        public void execute(ExecAction execAction) {
          execAction.args(pipCommand, "install", "--no-deps", dependency.getAbsolutePath());
        }
      });
    }

    GFileUtils.writeFile(stringBuilder.toString(), getInstalledDependencies());
  }

  @OutputFile
  File getInstalledDependencies() {
    return new File(getPythonBuilDir(), getName() + ".txt");
  }

  @InputFiles
  Configuration getVirtualEnvFiles(){
    return virtualEnvFiles;
  }

  public void setVirtualEnvFiles(Configuration configuration) {
    this.virtualEnvFiles = configuration;
  }
}
