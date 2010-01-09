/*
Copyright 2009 Michael Cramer

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.webkist.android.DarkroomTimer;

import java.util.ArrayList;

public class DarkroomPreset {
	public String name;
	public String id;
	private int currentStep = 0;
	private ArrayList<DarkroomStep> steps = new ArrayList<DarkroomStep>();

	public static final String TAG = "DarkroomPreset";

	DarkroomPreset(String id, String name) {
		this.name = name;
		this.id = id;
	}

	public DarkroomStep addStep(String name, int duration, int agitateEvery, String clickPrompt, int pourFor) {
		DarkroomStep s = new DarkroomStep(name, duration, agitateEvery, clickPrompt, pourFor);
		steps.add(s);
		return s;
	}

	public String toString() {
		return name;
	}

	public void reset() {
		currentStep = 0;
	}
	
	public DarkroomStep nextStep() {
		if(currentStep < steps.size()) {
			return steps.get(currentStep++);
		} else {
			return null;
		}
	}


	public int totalDuration() {
		int total=0;
		for(int i=0; i<steps.size(); i++) {
			total += steps.get(i).duration;
		}
		return total;
	}
	
	public class DarkroomStep {
		public String name;
		public int duration;
		public int agitateEvery = 0;
		public int agitateFor = 10;
		public String promptBefore = null;
		public int pourFor = 0;

		DarkroomStep(String name, int duration, int agitateEvery, String clickPrompt, int pourFor) {
			this.name = name;
			this.duration = duration;
			this.promptBefore = clickPrompt;
			this.agitateEvery = agitateEvery;
			this.pourFor = pourFor;
		}

		public String toString() {
			return this.name;
		}
	}

}
