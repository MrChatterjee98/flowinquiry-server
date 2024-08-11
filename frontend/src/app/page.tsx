'use client';

import {useSession} from "next-auth/react";
import {redirect} from "next/navigation";

export default function Home() {
    const { data: session } = useSession();
    if (!session) {
        console.log("No session defined. Redirect to login page")
        redirect("/login");
    } else {
        redirect("/portal");
    }
}