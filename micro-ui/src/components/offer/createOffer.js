/*
 * Copyright (c) 2018, Okta, Inc. and/or its affiliates. All rights reserved.
 * The Okta software accompanied by this notice is provided pursuant to the Apache License, Version 2.0 (the "License.")
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under the License.
 */

import { withAuth } from '@okta/okta-react';
import React, { Component } from 'react';
import { Header, Icon, Message, Table } from 'semantic-ui-react';
import axios from 'axios';

export default withAuth(class CreateOffer extends Component {
  constructor(props) {
    super(props);
    this.state = { messages: null, failed: null };
  }

  componentDidMount() {
    this.getMessages();
  }

  async getMessages() {
    if (!this.state.messages) {
      try {
        const accessToken = await this.props.auth.getAccessToken();
        console.log(`accessTocken------`,accessToken)
        /* global fetch */
       /* const response = await fetch("http://localhost:12040/cat-service/1.0/InitData", {
          headers: {
            Authorization: `Bearer ${accessToken}`,
          },
        });*/
       // axios.defaults.headers.common['Authorization'] = `Bearer ${accessToken}`;
        axios.get("http://localhost:12040/cat-service/1.0/InitData",{ headers: { Authorization: `Bearer ${accessToken}` } }).then(res => {
               console.log(`axios res--------`,res);
               this.setState({ messages : JSON.stringify(res,undefined,2), failed: false });
        }).catch(error=>{console.log(`error`, error)});

       
        /*let index = 0;
        const messages = await response.json();
        this.setState({ messages : JSON.stringify(messages,undefined,2), failed: false });*/
      } catch (err) {
        this.setState({ failed: true });
        /* eslint-disable no-console */
        console.error(err);
      }
    }
  }

  render() {
    const possibleErrors = [
      'You\'ve downloaded one of our resource server examples, and it\'s running on port 8000.',
      'Your resource server example is using the same Okta authorization server (issuer) that you have configured this React application to use.',
    ];
    return (
      <div>
        <Header as="h1"><Icon name="mail outline" /> My Messages</Header>
        {this.state.failed === true && <Message error header="Failed to fetch messages.  Please verify the following:" list={possibleErrors} />}
        {this.state.failed === null && <p>Fetching Messages..</p>}
        {this.state.messages &&
          <div>
            <p>This component makes a GET request to the resource server example, which must be running at <code>localhost:8000/api/messages</code></p>
            <p>
              It attaches your current access token in the <code>Authorization</code> header on the request,
              and the resource server will attempt to authenticate this access token.
              If the token is valid the server will return a list of messages.  If the token is not valid
              or the resource server is incorrectly configured, you will see a 401 <code>Unauthorized response</code>.
            </p>
            <p>
              This route is protected with the <code>&lt;SecureRoute&gt;</code> component, which will
              ensure that this page cannot be accessed until you have authenticated and have an access token in local storage.
            </p>
           <div>Offer JSON</div>
           <pre>{this.state.messages}</pre>
          </div>
        }
      </div>
    );
  }
});
