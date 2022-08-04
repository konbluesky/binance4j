import clientModules from '@generated/client-modules';
import CodeBlock from '@theme/CodeBlock';
import TabItem from '@theme/TabItem';
import Tabs from '@theme/Tabs';
import React from 'react';

/**
 * A set of components generating example code blocks for sync and async API call methods
 */

/** The request examples components's props */
interface Props {
    /** The method */
    method: string,
    /** The method return type */
    payload?: string,
}

/**
 * Returns an example code block for a sync API call
 * @param props The components props
 */
export function SyncRequest(props: Props) {
    return (
        <CodeBlock language="java">
            {`try{
    ${props.payload} res = client.${props.method}.sync();
}catch(ApiException e){ 
//...
}`}
        </CodeBlock>
    )
}

/**
 * Returns an example code block for an async API call with lambda
 * @param props The components props
 */
export function AsyncRequestLambda(props: Props) {
    return (
        <CodeBlock language="java">
            {`client.${props.method}.async(response->{
//...
});`}
        </CodeBlock>
    )
}

/**
 * Returns an example code block for an async API call with ApiCallback
 * @param props The components props
 */
export function AsyncRequestApiCallback(props: Props) {
    const callback = props.payload ? `${props.payload} response` : "";

    return (
        <CodeBlock language="java">
            {`client.${props.method}.async(new ApiCallback<${props.payload ? props.payload : "Void"}>() {
    @Override
    public void onResponse(${callback}) {
        //...
    }

    @Override
    public void onFailure(ApiException exception) {
        //...
    }
});
`}
        </CodeBlock>
    )
}

/**
 * Returns all the examples in a Tabs item
 * @param props The components props
 */
export default function RequestExamples(props: Props) {
    return (
        <>
            <Tabs>
                <TabItem label="Sync" value="sync" default>
                    <SyncRequest {...props} />
                </TabItem>
                <TabItem label="Async (lambda)" value="async-lambda">
                    <AsyncRequestLambda {...props} />
                </TabItem>
                <TabItem label="Async (ApiCallback)" value="async-api-callback">
                    <AsyncRequestApiCallback {...props} />
                </TabItem>
            </Tabs>
        </>
    )
}

export function ExampleList(props: { children: JSX.Element[], labels: string[] }) {
    return (
        <>
            <Tabs>
                {props.children.map((c, i) => <TabItem key={i} value={i.toString()} label={props.labels[i]} default>{c}</TabItem>)}
            </Tabs>
        </>
    )
}