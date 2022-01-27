<!--
SPDX-FileCopyrightText: 2022 Alliander N.V.

SPDX-License-Identifier: Apache-2.0
-->

[![Maven Build Github Action Status](<https://img.shields.io/github/workflow/status/com-pas/compas-scl-validator/Maven%20Build?logo=GitHub>)](https://github.com/com-pas/compas-scl-validator/actions?query=workflow%3A%22Maven+Build%22)
[![REUSE status](https://api.reuse.software/badge/github.com/com-pas/compas-scl-validator)](https://api.reuse.software/info/github.com/com-pas/compas-scl-validator)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com-pas_compas-scl-validator&metric=alert_status)](https://sonarcloud.io/dashboard?id=com-pas_compas-scl-validator)
[![LFX Security Status](https://img.shields.io/badge/dynamic/json?color=orange&label=LFX%20Security%20Tool&query=issues%5B%3F%28%40%5B%27repository-name%27%5D%20%3D%3D%20%27compas-scl-validator%27%29%5D%5B%27high-open-issues%27%5D&suffix=%20High%20open%20issues&url=https%3A%2F%2Fapi.security.lfx.linuxfoundation.org%2Fv1%2Fproject%2Fe8b6fdf9-2686-44c5-bbaa-6965d04ad3e1%2Fissues)](https://security.lfx.linuxfoundation.org/#/e8b6fdf9-2686-44c5-bbaa-6965d04ad3e1/issues)
[![Slack](https://raw.githubusercontent.com/com-pas/compas-architecture/master/public/LFEnergy-slack.svg)](http://lfenergy.slack.com/)

# compas-scl-validator

Service to validate SCL Files.


## Common Environment variables

Below environment variable(s) can be used to configure which claims and information are used to fill the UserInfo
response.

| Environment variable             | Java Property                   | Description                                                 | Example          |
| -------------------------------- | ------------------------------- | ----------------------------------------------------------- | ---------------- |
| USERINFO_NAME_CLAIMNAME          | compas.userinfo.name.claimname  | The Name of the user logged in.                             | name             |
| USERINFO_WHO_CLAIMNAME           | compas.userinfo.who.claimname   | The Name of the user used in the Who History.               | name             |
| USERINFO_SESSION_WARNING         | compas.userinfo.session.warning | Number of minutes a Session Warning can be displayed.       | 20               |
| USERINFO_SESSION_EXPIRES         | compas.userinfo.session.expires | Number of minutes a Session Expires to display in Frontend. | 30               |

## Security

To use most of the endpoints the users needs to be authenticated using JWT in the authorization header. There are 4
environment variables that can be set in the container to configure the validation/processing of the JWT.

| Environment variable             | Java Property                    | Description                                        | Example                                                                |
| -------------------------------- | -------------------------------- | -------------------------------------------------- | ---------------------------------------------------------------------- |
| JWT_VERIFY_KEY                   | smallrye.jwt.verify.key.location | Location of certificates to verify the JWT.        | http://localhost:8089/auth/realms/compas/protocol/openid-connect/certs |
| JWT_VERIFY_ISSUER                | mp.jwt.verify.issuer             | The issuer of the JWT.                             | http://localhost:8089/auth/realms/compas                               |
| JWT_VERIFY_CLIENT_ID             | mp.jwt.verify.audiences          | The Client ID that should be in the "aud" claim.   | scl-validator                                                          |
| JWT_GROUPS_PATH                  | smallrye.jwt.path.groups         | The JSON Path where to find the roles of the user. | resource_access/scl-validator/roles                                    |
