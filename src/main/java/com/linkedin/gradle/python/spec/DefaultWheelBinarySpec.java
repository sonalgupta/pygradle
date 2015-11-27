package com.linkedin.gradle.python.spec;

import com.linkedin.gradle.python.internal.platform.PythonPlatform;
import com.linkedin.gradle.python.internal.toolchain.PythonToolChain;
import org.gradle.platform.base.binary.BaseBinarySpec;

import java.io.File;

public class DefaultWheelBinarySpec extends BaseBinarySpec implements WheelBinarySpec {

    private File virtualEnvDir;
    private File pythonBuildDir;
    private PythonPlatform pythonPlatform;
    private PythonToolChain pythonToolchain;
    private PythonComponentSpec pythonComponentSpec;

    @Override
    protected String getTypeName() {
        return "Wheel";
    }

    @Override
    public PythonPlatform getTargetPlatform() {
        return pythonPlatform;
    }

    @Override
    public void setTargetPlatform(PythonPlatform platform) {
        this.pythonPlatform = platform;
    }

    @Override
    public PythonToolChain getToolChain() {
        return pythonToolchain;
    }

    @Override
    public void setComponentSpec(PythonComponentSpec spec) {
        this.pythonComponentSpec = spec;
    }

    @Override
    public PythonComponentSpec getComponentSpec() {
        return pythonComponentSpec;
    }

    @Override
    public void setToolChain(PythonToolChain toolChain) {
        this.pythonToolchain = toolChain;
    }

    @Override
    public void setVirtualEnvDir(File virtualEnvDir) {
        this.virtualEnvDir = virtualEnvDir;
    }

    @Override
    public File getVirtualEnvDir() {
        return virtualEnvDir;
    }

    @Override
    public void setPythonBuildDir(File pythonBuildDir) {
        this.pythonBuildDir = pythonBuildDir;
    }

    @Override
    public File getPythonBuildDir() {
        return pythonBuildDir;
    }
}
