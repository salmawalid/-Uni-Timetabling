/*
 * Licensed to The Apereo Foundation under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 *
 * The Apereo Foundation licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
*/
package org.unitime.timetable.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

import org.unitime.timetable.model.User;

/**
 * Do not change this class. It has been automatically generated using ant create-model.
 * @see org.unitime.commons.ant.CreateBaseModelFromXml
 */
@MappedSuperclass
public abstract class BaseUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String iUsername;
	private String iPassword;
	private String iExternalUniqueId;


	public static String PROP_USERNAME = "username";
	public static String PROP_PASSWORD = "password";
	public static String PROP_EXTERNAL_UID = "externalUniqueId";

	public BaseUser() {
		initialize();
	}

	public BaseUser(String username) {
		setUsername(username);
		initialize();
	}

	protected void initialize() {}

	public String getUsername() { return iUsername; }
	public void setUsername(String username) {
		if (username == null || username.length() < 5) { // check if username is null or has fewer than 5 characters
			throw new IllegalArgumentException("Username must have at least 5 characters.");
		}
		iUsername = username;
	}

	public String getPassword() { return iPassword; }
	public void setPassword(String password) {
		if (password == null || password.isEmpty()) { // check if password is null or empty
			throw new IllegalArgumentException("Password cannot be empty.");
		} else if (password.length() < 8) { // check if password has fewer than 8 characters
			throw new IllegalArgumentException("Password must have at least 8 characters.");
		}
		iPassword = password;
	}

	public String getExternalUniqueId() { return iExternalUniqueId; }
	public void setExternalUniqueId(String externalUniqueId) {
		if (externalUniqueId == null || externalUniqueId.isEmpty()) { // check if externalUniqueId is null or empty
			throw new IllegalArgumentException("External Unique ID cannot be empty.");
		}
		iExternalUniqueId = externalUniqueId;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof User)) return false;
		if (getUsername() == null || ((User)o).getUsername() == null) return false;
		return getUsername().equals(((User)o).getUsername());
	}

	public int hashCode() {
		if (getUsername() == null) return super.hashCode();
		return getUsername().hashCode();
	}

	public String toString() {
		return "User["+getUsername()+"]";
	}

	public String toDebugString() {
		return "User[" +
			"\n	ExternalUniqueId: " + getExternalUniqueId() +
			"\n	Password: " + getPassword() +
			"\n	Username: " + getUsername() +
			"]";
	}
}