'use client';

import { Checkbox } from '@/components/ui/checkbox';
import { ColumnDef } from '@tanstack/react-table';
import { CellAction } from './cell-action';
import {Account} from "@/types/accounts";

export const columns: ColumnDef<Account>[] = [
    {
        id: 'select',
        header: ({ table }) => (
            <Checkbox
                checked={table.getIsAllPageRowsSelected()}
                onCheckedChange={(value) => table.toggleAllPageRowsSelected(!!value)}
                aria-label="Select all"
            />
        ),
        cell: ({ row }) => (
            <Checkbox
                checked={row.getIsSelected()}
                onCheckedChange={(value) => row.toggleSelected(!!value)}
                aria-label="Select row"
            />
        ),
        enableSorting: false,
        enableHiding: false
    },
    {
        accessorKey: 'accountName',
        header: 'Name'
    },
    {
        accessorKey: 'accountType',
        header: 'Type'
    },
    {
        accessorKey: 'industry',
        header: 'Industry'
    },
    {
        id: 'actions',
        cell: ({ row }) => <CellAction data={row.original} />
    }
];