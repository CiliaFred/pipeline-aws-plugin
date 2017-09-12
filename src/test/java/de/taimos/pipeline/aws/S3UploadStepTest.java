/*
 * -
 * #%L
 * Pipeline: AWS Steps
 * %%
 * Copyright (C) 2017 Taimos GmbH
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package de.taimos.pipeline.aws;

import org.junit.Assert;
import org.junit.Test;

public class S3UploadStepTest {
	@Test
	public void gettersWorkAsExpectedForFileCase() throws Exception {
		S3UploadStep step = new S3UploadStep( "my-bucket" );
		step.setFile( "my-file" );
		Assert.assertEquals( "my-file", step.getFile() );
		Assert.assertEquals( "my-bucket", step.getBucket() );
	}
	
	@Test
	public void gettersWorkAsExpectedForPatternCase() throws Exception {
		S3UploadStep step = new S3UploadStep( "my-bucket" );
		step.setIncludePathPattern( "**" );
		step.setExcludePathPattern( "**/*.svg" );
		step.setWorkingDir( "dist" );
		Assert.assertEquals( "dist", step.getWorkingDir() );
		Assert.assertEquals( "**", step.getIncludePathPattern() );
		Assert.assertEquals( "**/*.svg", step.getExcludePathPattern() );
		Assert.assertEquals( "my-bucket", step.getBucket() );
	}

	@Test
	public void defaultPathIsEmpty() throws Exception {
		S3UploadStep step = new S3UploadStep( "my-bucket" );
		step.setFile( "my-file" );
		Assert.assertEquals( "", step.getPath() );
	}
}
