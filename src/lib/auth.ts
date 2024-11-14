import { UserType } from "@/types/users";

import { BACKEND_API } from "./constants";

export default async function apiAuthSignIn(
  credentials: Partial<Record<"email" | "password", unknown>> | undefined,
) {
  const response = await fetch(`${BACKEND_API}/api/login`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(credentials),
  });

  if (response.ok) {
    const bearerToken = response.headers.get("authorization");
    const jwt =
      bearerToken && bearerToken.slice(0, 7) === "Bearer "
        ? bearerToken.slice(7, bearerToken.length)
        : "";
    const remoteUser = (await response.json()) as UserType;
    return { ...remoteUser, accessToken: jwt };
  } else {
    throw new Error("Can not login " + response.status);
  }
}
